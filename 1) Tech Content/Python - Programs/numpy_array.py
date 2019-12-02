import numpy
height = numpy.array([1.3, 1.5, 1.5])
weight = numpy.array([52, 62, 60])
bmi = weight / height ** 2
print(type(bmi))
print(bmi)
