import pymysql

connection = pymysql.connect(host='localhost', port=3306, user='root', password='root', db='mt_db')

e = connection.cursor()

query = 'select * from `employee_details`;'

count = e.execute(query)

print(type(count))

data = e.fetchall()

i=0
print('mid ','name ','email ','mobile ','address ','designation ')
mid = []
name = []
email = [] 
mobile = []
address = []
designation = []
while count > 0:
	a, b, c, d, e, f = data[i]
	mid.append(a)
	name.append(b)
	email.append(c)
	mobile.append(d)
	address.append(e)
	designation.append(f)
	i += 1
	count -= 1
	
	
mylist = zip(mid, name, email, mobile, address, designation)
print(type(mylist))
print(mylist[0])

		

#print(type(data))
#print(data)

