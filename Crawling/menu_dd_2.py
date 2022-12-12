import requests
from bs4 import BeautifulSoup
import time
from datetime import datetime
import http.client
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db  # realtime db
from firebase_admin import firestore  # firestore

start_time = time.perf_counter()


# Use a service account
cred = credentials.Certificate('C:/Users/qldls/Documents/EAT-SSU/Crawling/mykey.json')
firebase_admin.initialize_app(cred)

db = firestore.client()


# print(datetime.today().weekday())
ary=[]

for i in range(12,17):
    if i<10:
        i=f"0{i}"
    ary.append(requests.get(f"http://m.soongguri.com/m_req/m_menu.php?rcd=2&sdt=202212{i}"))


ddlist2=[]
for i in ary:
    soup = BeautifulSoup(i.text, "html.parser")
    project=soup.find("b")
    도담식당메뉴=project.find_next()
    print(도담식당메뉴.text)
    ddlist2.append(도담식당메뉴.text)


end_time = time.perf_counter()
print(f"time elapsed : {int(round((end_time - start_time) * 1000))}ms")
    