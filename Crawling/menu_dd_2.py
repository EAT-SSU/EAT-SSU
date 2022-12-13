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


ddlist1=[]
for i in ary:
    soup = BeautifulSoup(i.text, "html.parser")
    project=soup.find("b")
    도담식당메뉴=project.find_next()
    print(도담식당메뉴.text)
    ddlist1.append(도담식당메뉴.text)

ddlist4=[]
for i in ary:
    soup = BeautifulSoup(i.text, "html.parser")
    em=soup.find(text="중식4")
    도담식당메뉴3=em.find_next("b")
    print(도담식당메뉴3.text)
    ddlist4.append(도담식당메뉴3.text)

ddlistN=[]
for i in ary:
    soup = BeautifulSoup(i.text, "html.parser")
    em=soup.find(text="석식1")
    도담식당석식=em.find_next("b")
    print(도담식당석식.text)
    ddlistN.append(도담식당석식.text)


end_time = time.perf_counter()
print(f"time elapsed : {int(round((end_time - start_time) * 1000))}ms")



for i in range(0,6):
    시간='2022.12.'+ str(i+12)
    도담_doc_ref = db.collection(u'숭실도담식당').document(u'{0}'.format(시간)).collection(u'메뉴')
    도담_doc_ref.document('중식1').set({
        u'메뉴': "{0}".format(ddlist1[i]),        
        })
    도담_doc_ref.document('중식4').set({
        u'메뉴': "{0}".format(ddlist4[i]),        
        })
    도담_doc_ref.document('석식').set({
        u'메뉴': "{0}".format(ddlistN[i]),        
        })