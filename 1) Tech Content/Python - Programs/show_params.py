
##################################################################################################################################
#    Python Script to remotely login to Linux Virtual Machine on any Cloud/Local Platform                                        #
#               Objectives:                                                                                                      #
#                       1. Import necessary Python module                                                                        #
#                       2. Prompt user to enter required information like IP,platform,username,password/key path in the form of arguments    #
#                       3. After successful login attempt, ping and validate                                                     #
#                       4. Create new directory and sub directory as per input                                                   #
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
def file_open(logfilename):
        #cur_time = get_time()
        f_name = logfilename+'.txt'
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
	f.write("\n\t %s \t\t %s \n" % (cur_time, content_to_file))

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
        print(   "\t\t  -1st Argument -> IP Address can be entered in the following format:")
        print(   "\t\t\t        x.x.x.x where x should be between 1 and 255\n")
        print(   "\t\t  -2nd Argument ->       Platform can be any of the following:")
        print(   "\t\t\t        aws, azure, google or local\n")
        print(   "\t\t  -3rd  Argument ->  Authentication Type can be of the following:")
        print(   "\t\t\t        password or key\n")
        print(   "\t\t  -4th  Argument ->  Credentials should be entered in the format:")
        print(   "\t\t\t        Username Password/KeyPath [seperated by <space>]\n")
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
        print(get_time()+"\tArguments check in  progress....")
        if  input_count != 4:
                file_write("Improper input!!!!!!!!! \tRefer the instructions and enter the input accordingly")
                print(get_time()+"\tImproper input!!!!!!!!! \tRefer the instructions and enter the input accordingly")
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
        global input_ip, input_cloud, input_type, input_credendtial
        input_ip, input_cloud, input_type, input_credendtial = input_check[1]
        ccheck = validate_credentials()
        file_header()
        file_write("Arguments check in  progress....")
        ping_check = Ping(input_ip)
        if ping_check == 1:
                file_write("IP Validation Successfully completed")
                print(get_time()+"\tIP Validation Successfully completed")
                if input_cloud == 'aws':
                        file_write("Cloud Service Provider Validated")
                        print(get_time()+"\tCloud Service Provider Validated")
                        if input_type == 'key':
                                global type_flag
                                type_flag = 1
                                if ccheck == 1:
                                        file_write("Username and Key extracted")
                                        print(get_time()+"\tUsername and Key extracted")
                                        file_write("Input Validataion Successfully Completed")
                                        print(get_time()+"\tInput Validataion Successfully Completed")
                                        return 1
                                else:
                                        file_write("Username or Key is missing, Refer Banner for proper format of the input!!!!!")
                                        print(get_time()+"\tUsername or Key is missing, Refer Banner for proper format of the input!!!!!")
                                        return 0
                        elif input_type == 'password':
                                type_flag = 0
                                if ccheck == 1:
                                        file_write("Username and Password extracted")
                                        print(get_time()+"\tUsername and Password extracted")
                                        file_write("Input Validataion Successfully Completed")
                                        print(get_time()+"\tInput Validataion Successfully Completed")
                                        return 1
                                else:
                                        file_write("Username or Password is Missing, Refer Banner for proper format of the input!!!!!")
                                        print(get_time()+"\tUsername or Password is Missing, Refer Banner for proper format of the input!!!!!")
                                        return 0
                        else:
                                file_write("Enter allowed type of Authentication \n\tRefer banner for more information")
                                print(get_time()+"\tEnter allowed type of Authentication \n\tRefer banner for more information")
                                return 0
                else:
                        file_write("Enter only allowed service provider name \n\tRefer banner for more information")
                        print(get_time()+"\tEnter only allowed service provider name \n\tRefer banner for more information")
                        return 0
        else:
                file_write("Check your IP again!!!!!!!!!")
                print(get_time()+"\tCheck your IP again!!!!!!!!!")
                return 0

# function to aunthenticate based with the password
def PasswordBased(ip, user, passwd):
        file_write("PasswordBased Authentication started.......")
        print(get_time()+"\tPasswordBased Authentication started.......")
        # file_write("30% of the process completed....")
        # print(get_time()+"\t30% of the process completed....")
        #time.sleep(1)
        file_write("PasswordBased Authentication started.......")
        print(get_time()+"\tPasswordBased Authentication started.......")
        global client
        client = paramiko.SSHClient()
        client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        client.connect(ip, username=user, password=passwd)
        file_write("SSH connection established to "+ip)
        print(get_time()+"\tSSH connection established to "+ip)
        # file_write("50% of the process completed....")
        # print(get_time()+"\t50% of the process completed....")

# function to authenticate based on the key
def KeyBased(ip, user_name, key):
        file_write("KeyBased Authentication started.......")
        print(get_time()+"\tKeyBased Authentication started.......")
        # file_write("30% of the process completed....")
        # print(get_time()+"\t30% of the process completed....")
        private_key = paramiko.RSAKey.from_private_key_file(key)
        global client
        client = paramiko.SSHClient()
        client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        client.connect(ip, username=user_name, pkey=private_key)
        file_write("SSH connection established to "+ip)
        print(get_time()+"\tSSH connection established to %s" % ip)
        # file_write("50% of the process completed....")
        # print(get_time()+"\t50% of the process completed....")

# to execute the command in the servers
def execute_command(cmd_recieved):
	# client_stdin, client_stdout, client_stderr = client.exec_command("ls")
	client_stdin, client_stdout, client_stderr = client.exec_command("sudo "+cmd_recieved)
#	client_stdin, client_stdout, client_stderr = client.exec_command("sudo cat /tmp/xxxx")
	output = client_stdout.readlines()
	global output1
	output1 = " ".join(str(x) for x in output) # converting list into string
	err_output = client_stderr.readlines()
	global err_output1
	err_output1 = " ".join(str(x) for x in err_output) # converting list into string
	output = output[1].decode('utf-8')
	#print(output)
	#print(err_output)
	# client_stdin, client_stdout, client_stderr = client.exec_command("sudo rm /tmp/xxxx")
	#if any(err_output):
	if (output == "  \"roleTypeConfigs\" : [ {\n"):
		return [1, ''.join(err_output1), ''.join(output1)]
	else:
		return [0, ''.join(err_output1), ''.join(output1)]

# to create the directory
def activity():
	file_write("Commands Execution started.... Please wait")
	print(get_time()+"\tCommands Execution started.... \n\tPlease wait")
	# file_write("75% of the process is completed....")
	# print(get_time()+"\t75% of the process is completed....")
	global cmd_list
	val = Parameter_Count()
	# val = "pwd"
	# print(val)
	r_val, err_msg, output_msg = execute_command(val)
	if r_val == 0:
		#print(get_time()+"\t further commands can't be continued in execution, due to failure of the below command")
		print(get_time()+"\tActivity Failed")
		file_write("further commands can't be continued in execution, due to failure of the below command")
		#print(get_time()+"\t",val)
		file_write(str(val))
		#print(get_time()+"\t",err_msg)
		file_write(str(output_msg))
		# execute_rback(task_count)
		exit()
	else:
		#print(get_time()+"\tBelow command executed successfully!!!!!!!!!!!!")
		#print(get_time()+"\t"+val)
		file_write(str(val))
		#print(get_time()+"\tOutput")
		#print(get_time()+"\t"+output_msg)
		file_write(output_msg)

def Parameter_Count():
	if len(sys.argv) == 9:
		activity_cmd = show_params(sys.argv[3], sys.argv[4], sys.argv[5], sys.argv[6], sys.argv[7], sys.argv[8])
		return activity_cmd
	else:
		return "invalid command count"

def show_params(username, password, host, port, cluster_name, service_name):
	actual_cmd = "curl --max-time 2 -s -u %s:%s \'http://%s:%s/api/v1/clusters/%s/services/%s/config?view=full\'" %(username, password, host, port, cluster_name, service_name)
	return actual_cmd

# Main Function where actual calling of all the other functions
def MainFunc():
	if len(sys.argv) >= 2:
			file_open(sys.argv[2])
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
									print(get_time()+"\tFailed input validation")
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
			# print(get_time()+"\t100% of the process is completed....")
			#print(get_time()+"\tCommands Execution Completed")
			print(get_time()+"\tActivity Completed")
			file_close()
	except Exception as e:
			file_write("\n\tFailure due to these reasons: ")
			#print(get_time()+"\tFailure due to these reasons: ")
			file_write(e)
			#print(get_time()+"\t", e)
			print(get_time()+"\tActivity Failed")
			file_close()

# calling the main function
MainFunc()
