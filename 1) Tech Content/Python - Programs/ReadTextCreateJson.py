import json, sys
global new_dict
new_dict = {"pre_requisites": [], "commands": [], "rollback": [] }

def generate_json(file_name):
	data = new_dict 
	with open(file_name, 'w+') as outfile:
		json.dump(data, outfile)

def load_content(section_name, input_file_name = 0 ):
	new_list = [] 
	if input_file_name != 0:
		f = open(input_file_name,'r')
		data_from_file = f.readlines()
		for val in data_from_file:
			val = val.replace("\n","")
			sub_dict = {"cmd": val}
			new_list.append(sub_dict)
	new_dict[section_name] = new_list

def main_function():
	args_count = len(sys.argv)
	if args_count >= 3:
		load_content("commands",sys.argv[2])
		if args_count >= 4:
			load_content("pre_requisites",sys.argv[3])
			if args_count >= 5:
				load_content("rollback",sys.argv[4])
		generate_json(sys.argv[1])
	else:
		print("arguments missing!!!!")
		

main_function()
