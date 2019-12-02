import datetime
def get_time():
	o_time = str(datetime.datetime.now())
	cur_time = o_time.replace(" ","_")
	return cur_time
	
	
get_time()