import json

def load_parse_json():
	with open('Data.json') as f:
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
	
cmd_lsit = load_parse_json()
for cmd in cmd_lsit:
	for val in cmd:
		print(val)