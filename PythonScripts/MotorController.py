import PiMotor

m1 = PiMotor.Motor("MOTOR1",1)
m2 = PiMotor.Motor("MOTOR2",1)
m3 = PiMotor.Motor("MOTOR3",1)
m4 = PiMotor.Motor("MOTOR4",1)

def startMotor(motorNum, time):
	motor = ""
	if(motorNum == 1):
		motor = m1
	elif (motorNum == 2):
		motor = m2
	elif (motorNum == 3):
		motor = m3
	elif (motorNum == 4):
		motor = m4
	else 
		return
		
	motor.forward(100)
    time.sleep(time)
	m.stop()