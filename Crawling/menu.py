import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
import requests
from bs4 import BeautifulSoup
import time
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db  # realtime db
from firebase_admin import firestore  # firestore

# Use a service account
cred = credentials.Certificate('Crawling/myKey.json')
firebase_admin.initialize_app(cred)

db = firestore.client()

##파일 쓰기


# doc_ref = db.collection(u'menus').document(u'20221204')
# doc_ref.set({
#     u'도담식당_1_0': "쭈꾸미",
#     u'도담식당_1_1': "하이라이스",
#     u'도담식당_2_0': "고등어구이",
#     u'학생식당_1_0': "라멘",
#     u'학생식당_1_1': "볶음밥",
#     u'학생식당_1_1': "오므라이스",
#     u'기숙사식당_0': "토스트",
#     u'기숙사식당_1': "짬뽕",
#     u'기숙사식당_2': "탕수육"
# })

##파일 읽기

# users_ref = db.collection(u'users')
# docs = users_ref.stream()

# for doc in docs:
#     print(u'{} => {}'.format(doc.id, doc.to_dict()))




ser = Service("C:/Users/qldls0307/chromedriver.exe")
# 크롬 드라이버 잡아주는 것
op = webdriver.ChromeOptions()  # initial
op.add_experimental_option("excludeSwitches", ["enable-logging"])  # option 주기
# op.add_argument("headless")  # option 주기
s = webdriver.Chrome(service=ser, options=op)  # 초기화

s.get("http://m.soongguri.com/")

time.sleep(3)


html = s.page_source
soup = BeautifulSoup(html, 'html.parser')
items = soup.select(
    '#mainDiv > table > tbody > tr:nth-child(2) > td.menu_list>div')
container = []
for i in items:
    container.append(i.text)


# 요일 바꾸기 도전!
for i in range(1,7): #1월~6토
    #닫기 버튼
    닫기 = s.find_element(
        By.XPATH, '//*[@id="smenu1"]/div[3]/div')
    닫기.click()
    
    week = s.find_element(
        By.XPATH, '//*[@id="useDt{0}"]'.format(i))
    # week= s.find_element(By.ID, "useDt{0}".format(i))
    week.click()
    
    #도큐먼트 이름
    day =soup.select('#viewDt')
        #By.XPATH, '//*[@id="viewDt"]')
    date=[]
    for i in day:
        date.append(i.text)
    print(date)

    #오늘의 식단 클릭
    오늘의식단 = s.find_element(
        By.XPATH, '//*[@id="menuTop1"]')
    오늘의식단.click()


    Button = s.find_element(By.NAME, "rest")
    숭실도담식당 = s.find_element(
        By.CSS_SELECTOR, "#smenu1 > div:nth-child(1) > div > div > select > option:nth-child(2)")#value2 도담
    Button.click()
    숭실도담식당.click()

    time.sleep(3)
    html = s.page_source

    
    dd_container=[]
    도담soup = BeautifulSoup(html, 'html.parser')
    중식1=도담soup.select("#mainDiv > table > tbody > tr:nth-child(2) > td.menu_list > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > b")
    중식4=도담soup.select("#mainDiv > table > tbody > tr:nth-child(4) > td.menu_list > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > b")
    석식1=도담soup.select("#mainDiv > table > tbody > tr:nth-child(6) > td.menu_list > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > b")


        #"#mainDiv > table > tbody > tr:nth-child(2) > td.menu_list > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > b")
        #'#mainDiv > table > tbody > tr:nth-child(2) > td.menu_list>div')
    # mainDiv > table > tbody > tr:nth-child(2) > td.menu_list > div:nth-child(1)
    for i in 중식1:
        dd_container.append(i.text)
    for i in 중식4:
        dd_container.append(i.text)
    for i in 석식1:
        dd_container.append(i.text)
    for i in dd_container:
        print(i)
    # print(container)
    time.sleep(3)  # 추후 명시적 대기로 바꾸어야 함


    #형식
    #식당 이름_아침0/점심1/저녁2_메뉴종류0~2
    doc_ref = db.collection(u'menus').document(u'{0}'.format(date[0]))
    doc_ref.set({
        u'기숙사식당_0': "계란후라이",
        u'기숙사식당_1': "카레",
        u'기숙사식당_2': "짜장면",
        u'도담_중식1': "{0}".format(dd_container[0]),
        u'도담_중식4': "{0}".format(dd_container[1]),
        u'도담_석식1': "{0}".format(dd_container[2]),
        u'학생식당_1_0': "김치나베뚝배기",
        u'학생식당_1_1': "김치참치덮밥",
        u'학생식당_1_1': "오므라이스",

    })
    html = s.page_source