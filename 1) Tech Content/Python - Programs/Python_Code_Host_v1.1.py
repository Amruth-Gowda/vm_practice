##################################################################################################################################
#    Python Script to remotely login to Linux Virtual Machine on any Cloud/Local Platform   		                             #
#		Objectives:                                                                         									 #
#			1. Import necessary Python module    																				 #
#			2. Prompt user to enter required information like IP,platform,username,password/key path in the form of arguments    #
#			3. After successful login attempt, ping and validate 			                                                     #
#			4. Create new directory and sub directory as per input		                      									 #
##################################################################################################################################

import threading, subprocess, sys, getpass, time, os, paramiko, json, datetime

global user_input
global type_flag

# fecth the system time and date
def get_time():
	o_time = str(datetime.datetime.now())
	cur_time = o_time.replace(":","-")
	cur_time = cur_time.replace(" ","_")
	return cur_time
	
# opens the file and loads it 
def file_open():
	cur_time = get_time()
	f_name = 'Log_File_'+cur_time+'.txt'
	global f
	f = open(f_name,'w+')

# log file header
def file_header():
	f.write("#######################################################################################################################################")
	f.write("\n\t\t\tLog file")
	f.write("\n\t\t\t\tClient Server IP: "+input_ip)
	f.write("\n\t\t\t\tUser Name: "+username)
	f.write("\n\t\t\t\tLog file created on: "+get_time()+"\n")
	f.write("#######################################################################################################################################")
	f.write("\n\n")

# writes the contents on to the file	
def file_write(content_to_file):
	cur_time = get_time()
	f.write("\n\t %s \t\t %s" % (cur_time, content_to_file))

# closes the file which is opened
def file_close():
	f.close()

# provides information to the user about the parameters
def banner():
	print(   "\n\t")
	print(   "******************************************************************************************************************")
	print(   "Python Script to remotely login to Linux Virtual Machine on any Cloud/Local Platform\n")
	print(   "\n\t Please Pass the command line Argument in the following format:")
	print(   "\t\t 1-> <IP Address>,2 -> Platform,3 -> Authentication Type, 4 -> Credentials\n")
	print(   "\t\t	-1st Argument -> IP Address can be entered in the following format:")
	print(   "\t\t\t	x.x.x.x where x should be between 1 and 255\n")
	print(   "\t\t	-2nd Argument ->       Platform can be any of the following:")
	print(   "\t\t\t	aws, azure, google or local\n")
	print(   "\t\t	-3rd  Argument ->  Authentication Type can be of the following:")
	print(   "\t\t\t	password or key\n")
	print(   "\t\t	-4th  Argument ->  Credentials should be entered in the format:")
	print(   "\t\t\t	Username Password/KeyPath [seperated by <space>]\n")
	print(   "\t\tSequence of arguments must be::1st -> 2nd ->3rd -> 4th")  
	print(   "\n\n\t-For example:")
	print(   "\tpython filename.py \"192.168.10.1,aws,key,ec2-user C:\\Users\\m1045610\\Downloads\\lin.pem\"")
	print(   "******************************************************************************************************************")
	print(   "\n\t")
	
# to check the connectivity
def Ping(input_ip):
	return 1
	"""
	response = os.system("ping -n 1 " + input_ip)
	if response == 1:
		file_write("There is a connectivity issue with your server")
		print("\n\tThere is a connectivity issue with your server")
		return 0
	else:
		file_write("Server is up and Running")
		print("\n\tServer is up and Running")
		return 1
	"""
	
# validates the number of parameters passed
def validate_arguments_count(user_input):
	input_list = user_input.rsplit(",")
	input_count = len(input_list)
	print("\n\tArguments check in  progress....") 
	if  input_count != 5:
		file_write("Improper input!!!!!!!!! \tRefer the instructions and enter the input accordingly")
		print("\n\tImproper input!!!!!!!!! \tRefer the instructions and enter the input accordingly")
		return_value = 0
		output_sent = (return_value, input_list)
		return output_sent
	else:	
		return_value = 1
		output_sent = (return_value, input_list)
		return output_sent

# validae the creadentials part of the parameters passed
def validate_credentials():
	delimeter_count = input_credendtial.count(" ")
	if delimeter_count == 1:
		global username, pass_key
		username, pass_key = input_credendtial.rsplit(" ")
		return 1
	else:	
		return 0

		
# validate the given input	
def validate_input():
	global input_ip, input_cloud, input_type, input_credendtial, input_json
	input_ip, input_cloud, input_type, input_credendtial, input_json = input_check[1]
	ccheck = validate_credentials()
	file_header()
	file_write("Arguments check in  progress....")
	ping_check = Ping(input_ip)
	if ping_check == 1:
		file_write("IP Validation Successfully completed")
		print("\n\tIP Validation Successfully completed")
		if input_cloud == 'aws':
			file_write("Cloud Service Provider Validated")
			print("\n\tCloud Service Provider Validated")
			if input_type == 'key':
				global type_flag
				type_flag = 1
				if ccheck == 1:
					file_write("Username and Key extracted")
					print("\n\tUsername and Key extracted")
					file_write("Input Validataion Successfully Completed")
					print("\n\tInput Validataion Successfully Completed")
					return 1
				else:
					file_write("Username or Key is missing, Refer Banner for proper format of the input!!!!!")
					print("Username or Key is missing, Refer Banner for proper format of the input!!!!!")
					return 0
			elif input_type == 'password':
				type_flag = 0
				if ccheck == 1:
					file_write("Username and Password extracted")
					print("\n\tUsername and Password extracted")
					file_write("Input Validataion Successfully Completed")
					print("\n\tInput Validataion Successfully Completed")
					return 1
				else:
					file_write("Username or Password is Missing, Refer Banner for proper format of the input!!!!!")
					print("Username or Password is Missing, Refer Banner for proper format of the input!!!!!")
					return 0
			else:
				file_write("Enter allowed type of Authentication \n\tRefer banner for more information")
				print("\n\tEnter allowed type of Authentication \n\tRefer banner for more information")
				return 0
		else:
			file_write("Enter only allowed service provider name \n\tRefer banner for more information")
			print("\n\tEnter only allowed service provider name \n\tRefer banner for more information")
			return 0
	else:
		file_write("Check your IP again!!!!!!!!!")
		print("\n\tCheck your IP again!!!!!!!!!")
		return 0

# function to aunthenticate based with the password
def PasswordBased(ip, user, passwd):
	file_write("PasswordBased Authentication started.......")
	print("\n\tPasswordBased Authentication started.......")
	# file_write("30% of the process completed....")
	# print("\n\t30% of the process completed....")
	#time.sleep(1)
	file_write("PasswordBased Authentication started.......")
	print("PasswordBased Authentication started.......")
	global client
	client = paramiko.SSHClient()
	client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
	client.connect(ip, username=user, password=passwd)
	file_write("SSH connection established to "+ip)
	print ("\n\tSSH connection established to "+ip)
	# file_write("50% of the process completed....")
	# print("\n\t50% of the process completed....")
	
# function to authenticate based on the key		
def KeyBased(ip, user_name, key):
	file_write("KeyBased Authentication started.......")
	print("\n\tKeyBased Authentication started.......")
	# file_write("30% of the process completed....")
	# print("\n\t30% of the process completed....")
	private_key = paramiko.RSAKey.from_private_key_file(key)
	global client
	client = paramiko.SSHClient()
	client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
	client.connect(ip, username=user_name, pkey=private_key)
	file_write("SSH connection established to "+ip)
	print("\n\tSSH connection established to %s" % ip)
	# file_write("50% of the process completed....")
	# print("\n\t50% of the process completed....")

# Reading commands from json
def load_parse_json(input_json):
	with open(input_json) as f:
		data = json.load(f)
	pre_requisites_cmds_list = []
	if 'pre_requisites' in data.keys():
		elements = data["pre_requisites"]
		for vals in elements:
			pre_requisites_cmds_list.append(vals["cmd"])
	tasks_cmds_list = []
	if 'commands' in data.keys():
		elements = data["commands"]
		for vals in elements:
			tasks_cmds_list.append(vals["cmd"])
	rollback_cmds_list = []
	if 'rollback' in data.keys():
		elements = data["rollback"]
		for vals in elements:
			rollback_cmds_list.append(vals["cmd"])
	all_cmds_list = []
	all_cmds_list.append(pre_requisites_cmds_list)
	all_cmds_list.append(tasks_cmds_list)
	all_cmds_list.append(rollback_cmds_list)
	return all_cmds_list

# to execute the command in the server
def execute_command(cmd_recieved):
	client_stdin, client_stdout, client_stderr = client.exec_command(cmd_recieved+";echo $?")
	output = client_stdout.readlines()
	err_output = client_stderr.readlines()
	# print(output)
	# print(err_output)
	if any(err_output):
		return [0, ''.join(err_output), ''.join(output)]
	else:
		return [1, ''.join(err_output), ''.join(output[:-1])]


def execute_rback(t_count):
	rback_list = cmd_list[2][0:t_count-1]
	# print(rback_list)
	for val in rback_list:
		r_val, err_msg, output_msg = execute_command(val)
		if r_val == 0:
			print("\n\t further commands can't be continued in execution, due to failure of the below command")
			file_write("further commands can't be continued in execution, due to failure of the below command")
			print("\n\t",val)
			file_write(val)
			print("\n\t",err_msg)
			file_write(err_msg)
			exit()
		else:
			file_write("ROLLBACK command executed successfully!!!!!!!!!!!!")
			print("\n\t below rollback command executed successfully!!!!!!!!!!!!")
			print("\n\t",val)
			file_write(val)
			print("\n\t",output_msg)
			# file_write(output_msg)


# to create the directory	
def activity():
	file_write("Commands Execution started.... Please wait")
	print("\n\tCommands Execution started.... \n\tPlease wait")
	# file_write("75% of the process is completed....")
	# print("\n\t75% of the process is completed....")
	global cmd_list
	cmd_list = load_parse_json(input_json)
	task_count = 0
	for cmd in cmd_list[0:2]:
		for val in cmd:
			if val in cmd_list[1]:
				task_count = task_count + 1
			r_val, err_msg, output_msg = execute_command(val)
			if r_val == 0:
				print("\n\t further commands can't be continued in execution, due to failure of the below command")
				file_write("further commands can't be continued in execution, due to failure of the below command")
				print("\n\t",val)
				file_write(str(val))
				print("\n\t",err_msg)
				file_write(str(err_msg))
				execute_rback(task_count)
				exit()
			else:
				print("\n\t Below command executed successfully!!!!!!!!!!!!")
				print("\n\t",val)
				file_write(str(val))
				print("\n\t",output_msg) 
				# file_write(str(output_msg))

				
# Main Function where actual calling of all the other functions	
def MainFunc():
	if len(sys.argv) == 2:
		file_open()
		flag = 1
		while(flag):
			user_input = sys.argv[1]
			global input_check
			input_check = validate_arguments_count(user_input)
			if input_check[0] == 1:
				vcheck = validate_input()
				if vcheck == 1:
					flag = 0
				else:
					file_write("Failed input validation")
					print("\n\tFailed input validation")
					banner()
					exit()
			else:
				banner()
				exit()
	else:
		banner()
		exit()
	try:
		if type_flag == 1:	
			KeyBased(input_ip, username, pass_key)
		if type_flag == 0:
			PasswordBased(input_ip, username, pass_key)
		activity()
		# file_write("100% of the process is completed....")
		file_write("Commands Execution Completed")
		# print("\n\t100% of the process is completed....")
		print("\n\tCommands Execution Completed")
		file_close()
	except Exception as e:
		file_write("\n\tFailure due to these reasons: ")
		print("\n\tFailure due to these reasons: ")
		file_write(e)
		print("\n\t", e)
		file_close()

# calling the main function
MainFunc()