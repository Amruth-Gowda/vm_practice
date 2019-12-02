import os

def Ping(input_ip):
	print(input_ip)
	response = os.system("ping -n 1 " + input_ip)
	print(response)
	print(type(response))
	if response == 0:
		print("\n\tThere is a connectivity issue with your server")
		return 0
	else:
		print("\n\tServer is up and Running")
		return 1
		
Ping("54.208.148.7")
		
