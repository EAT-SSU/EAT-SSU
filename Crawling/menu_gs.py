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



ser = Service("C:/Users/qldls0307/chromedriver.exe")
# 크롬 드라이버 잡아주는 것
op = webdriver.ChromeOptions()  # initial
op.add_experimental_option("excludeSwitches", ["enable-logging"])  # option 주기
# op.add_argument("headless")  # option 주기
s = webdriver.Chrome(service=ser, options=op)  # 초기화

s.get("https://ssudorm.ssu.ac.kr:444/SShostel/mall_main.php?viewform=B0001_foodboard_list&gyear=2022&gmonth=11&gday=27")

time.sleep(3)


html = s.page_source
soup = BeautifulSoup(html, 'html.parser')
date=[]

i=25
#for i in range(25,32): #월25~ 일3
day =soup.select('body > table:nth-child(4) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > table.boxstyle02 > tbody > tr:nth-child({0}) > th > a'.format(i))
for k in day:
    date.append(k.text)
print(date)

조식=soup.select('body > table:nth-child(4) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > table.boxstyle02 > tbody > tr:nth-child({0}) > td:nth-child({1})'.format(i,2))
중식=soup.select('body > table:nth-child(4) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > table.boxstyle02 > tbody > tr:nth-child({0}) > td:nth-child({1})'.format(i,3))
석식=soup.select('body > table:nth-child(4) > tbody > tr > td > table > tbody > tr > td:nth-child(3) > table.boxstyle02 > tbody > tr:nth-child({0}) > td:nth-child({1})'.format(i,4))

#25-2 월 조식
#31-2 일 조식
        
gs_container=[]
for i in 조식:
    gs_container.append(i.text)
for i in 중식:
    gs_container.append(i.text)
for i in 석식:
    gs_container.append(i.text)

for k in gs_container:
    print(k)

기식_doc_ref = db.collection(u'menus').document(u'2022.12.04(일)').collection(u'기숙사식당').document('기숙사식당메뉴')
기식_doc_ref.set({
    u'조식': "{0}".format(gs_container[0]),
    u'중식': "{0}".format(gs_container[1]),
    u'석식': "{0}".format(gs_container[2]),
})
html = s.page_source