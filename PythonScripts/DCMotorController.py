import PiMotor
import time
import sys

m1 = PiMotor.Motor("MOTOR1",1)
m2 = PiMotor.Motor("MOTOR2",1)
m3 = PiMotor.Motor("MOTOR3",1)
m4 = PiMotor.Motor("MOTOR4",1)

try:
    first_arg = int(float(sys.argv[1]))
    second_arg = int(float(sys.argv[2]))
except:
    first_arg = 15 # Do not use channel 15!
    second_arg = 15

def startMotor(motorNum=first_arg, timeNeeded=second_arg):
    motor = ""
    if(motorNum == 1):
        motor = m1
    elif (motorNum == 2):
        motor = m2
    elif (motorNum == 3):
        motor = m3
    elif (motorNum == 4):
        motor = m4
    else:
        return
		
    motor.forward(100)
    time.sleep(timeNeeded)
    motor.stop()
	
if __name__ == "__main__":    
    startMotor()