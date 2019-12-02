import pymysql

connection = pymysql.connect(host='localhost', port=3306, user='root', password='root', db='employment_tracking_system')

e = connection.cursor()

query = 'select * from `staff`;'

count = e.execute(query)

print(count)

output = e.fetchall()

print(type(output))


for val in output:
	print(id,name, gender, date, mail, designation, mob, location, mob, location, role)
	id, name, gender, date, mail, designation, mob, location, role = val