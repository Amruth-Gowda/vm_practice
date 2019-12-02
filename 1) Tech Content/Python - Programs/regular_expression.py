import re
of = open("C:\\Users\\M1045606\\Downloads\\postgresql.log.2018-10-30-05","r")
nf = open("C:\\Users\\M1045606\\Downloads\\postgresql.txt","w+")
data = of.readlines()
print(type(data))

for line in data:
	info_dict = {}
	date_time_counter = 0
	user_name_counter = 0
	date_time = re.search('.{4}-.{2}-.{2} .{2}:.{2}:.{2}',line)
	
	if date_time is not None:
		info_dict['datetime'] = date_time.group(0)
		date_time_counter = date_time_counter +  1
		if date_time_counter is 1:
			user_name = re.search('(:(\w+)@(\w+):)',line)
			if user_name is not None:
				info_dict['username'] = user_name.group(0)
				user_name_counter += 1
				if user_name_counter is 1:
					process_id = re.search(':\[(\d+)\]:',line)
					if process_id is not None:
						info_dict['processid'] = process_id.group(0)
						nf.write("\n")	
						nf.write(info_dict['datetime'])
						nf.write(" ")
						username_without_colon = info_dict['username']
						nf.write(username_without_colon[1:-1])
						nf.write(" ")
						proper_process_id = info_dict['processid']
						nf.write(proper_process_id[2:-2])
						nf.write(" ")
						string_data = re.search(':\[(\d+)\]:.*',line)
						if string_data is not None:
							info_dict['stringdata'] = string_data.group(0)
							nf.write(info_dict['stringdata'])
							nf.write(" ")
			else:
				info_dict['username'] = ':[unknown]@[unknown]:'
				user_name_counter += 1
				if user_name_counter is 1:
					process_id = re.search(':\[(\d+)\]:',line)
					if process_id is not None:
						info_dict['processid'] = process_id.group(0)
						nf.write("\n")						
						nf.write(info_dict['datetime'])
						nf.write(" ")
						username_without_colon = info_dict['username']
						nf.write(username_without_colon[1:-1])
						nf.write(" ")
						proper_process_id = info_dict['processid']
						nf.write(proper_process_id[2:-2])
						nf.write(" ")
						string_data = re.search(':\[(\d+)\]:.*',line)
						if string_data is not None:
							info_dict['stringdata'] = string_data.group(0)
							nf.write(info_dict['stringdata'])
	else:
		info_dict['stringdata'] = line.replace("\n"," ")
		nf.write(info_dict['stringdata'])
		
of.close()
nf.close()
print("success")

