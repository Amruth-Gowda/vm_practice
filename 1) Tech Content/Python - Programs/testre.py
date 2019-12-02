import re
of = open("C:\\Users\\M1045606\\Downloads\\postgresql.log.2018-10-30-05","r")
lines = of.readlines()
count = 0
for line in lines:
	pattern = re.search(':\[(\d+)\]:.*',line)
	if pattern is not None:	
		v = pattern.group(0).split(":")
		print(v[-2:])
	count += 1
	
	if count>5:
		break;
		
		
of.close()