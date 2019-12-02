import datetime
cur_time = datetime.datetime.now()
print(cur_time)
f_name = "sample.txt"
with open(f_name,'w+') as f:
	f.write("\nHello 3")
	f.write("\nHello 2")
	
