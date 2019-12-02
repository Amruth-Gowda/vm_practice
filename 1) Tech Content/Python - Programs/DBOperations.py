import sys

def loadDB():
	print("Loading")

def ExtractDB():
	print("Extracting")

def ExtractAndLoadingDB():
	print("ExtractAndLoadingDB")
	
	
def MainFunc():
	if len(sys.argv) >= 2:
		if str(sys.argv[1]) == "load":
			loadDB()
		elif str(sys.argv[1]) == "extract":
			ExtractDB()
		elif str(sys.argv[1]) == "extractload":
			ExtractAndLoadingDB()
		else:
			print("Please provide proper arguments ")
	else:
		print("Arguments Missing!!!!!!!!!!!")


MainFunc()