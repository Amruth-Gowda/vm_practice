import sys
mod_name = __import__(sys.argv[1])
print(mod_name)
recieved_input = mod_name.main_function()
print(recieved_input)