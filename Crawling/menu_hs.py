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
    ary.append(requests.get(f"http://m.soongguri.com/m_req/m_menu.php?rcd=1&sdt=202212{i}"))

    

hslist=[]
for i in ary:
    soup = BeautifulSoup(i.text, "html.parser")
    project=soup.find(text="----------")
    학생식당메뉴=project.find_next()
    print(학생식당메뉴.text)
    hslist.append(학생식당메뉴.text)



end_time = time.perf_counter()
print(f"time elapsed : {int(round((end_time - start_time) * 1000))}ms")
    

for i in range(12,17):
    시간='2022.12.'+ str(i)
    학식_doc_ref = db.collection(u'학생식당').document(u'{0}'.format(시간)).collection(u'메뉴').document('뚝배기')
    학식_doc_ref.set({
        u'메뉴': "{0}".format(hslist[0]),        
        })