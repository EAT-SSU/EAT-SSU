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

date_container=[]

# 요일 바꾸기 도전!
#for i in range(1,7): #1월~6토


i=2
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
학생식당= s.find_element(
    By.CSS_SELECTOR, "#smenu1 > div:nth-child(1) > div > div > select > option:nth-child(1)")#value1 학식
Button.click()
학생식당.click()



time.sleep(3)
html = s.page_source

hs_container=[]
학식soup = BeautifulSoup(html, 'html.parser')
중식1=학식soup.select("#mainDiv > table > tbody > tr:nth-child(2) > td.menu_list > div:nth-child(9)")
    #"#mainDiv > table > tbody > tr:nth-child(2) > td.menu_list > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > b")
중식2_1=학식soup.select("#mainDiv > table > tbody > tr:nth-child(4) > td.menu_list > div:nth-child(5)")
중식2_2=학식soup.select("#mainDiv > table > tbody > tr:nth-child(4) > td.menu_list > div:nth-child(7)")
중식2_3=학식soup.select("#mainDiv > table > tbody > tr:nth-child(4) > td.menu_list > div:nth-child(9)")
중식2_4=학식soup.select("#mainDiv > table > tbody > tr:nth-child(4) > td.menu_list > div:nth-child(11)")


    #"#mainDiv > table > tbody > tr:nth-child(2) > td.menu_list > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > b")
    #'#mainDiv > table > tbody > tr:nth-child(2) > td.menu_list>div')
# mainDiv > table > tbody > tr:nth-child(2) > td.menu_list > div:nth-child(1)
for i in 중식1:
    hs_container.append(i.text)
for i in 중식2_1:
    hs_container.append(i.text)
for i in 중식2_2:
    hs_container.append(i.text)
for i in 중식2_3:
    hs_container.append(i.text)
for i in 중식2_4:
    hs_container.append(i.text)

for i in hs_container:
    print(i)
# print(container)
time.sleep(3)  # 추후 명시적 대기로 바꾸어야 함

menuname= 값

학식_doc_ref = db.collection(u'menus').document(u'{0}'.format('2022.12.06')).collection(u'학생식당').document('학생식당메뉴')
학식_doc_ref.set({
    u'중식1': "{0}".format(hs_container[0]),
#    u'중식2_1': "{0}".format(hs_container[1]),
#    u'중식2_2': "{0}".format(hs_container[2]),
#    u'중식2_3': "{0}".format(hs_container[3]),
#    u'중식2_4': "{0}".format(hs_container[4]),
})
html = s.page_source