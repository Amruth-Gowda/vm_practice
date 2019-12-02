import datetime

global f

def get_time():
	o_time = str(datetime.datetime.now())
	cur_time = o_time.replace(" ","")
	return cur_time
	

def file_open():
	cur_time = get_time()
	f_name = 'LogFile'+cur_time	
	print(f_name)
	f = open(f_name,'w+')
	
def file_write(content_to_file):
	cur_time = get_time()
	f.write("\n"+cur_time+"\t"+content_to_file)
	
def file_close():
	f.close()	

file_open()
file_write("hello world from the arguments")
file_close()


