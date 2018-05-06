## Reference: http://rpi.science.uoit.ca/lab/servo/ 

import RPi.GPIO as GPIO
import time

sleep_time = 1 # number of seconds

def dispense_cereal(servings, tube_number):
    # To add more tube numbers, add another if clause
    if(tube_number == 0):
        pin_num = 3
    else:
        return

    # change to BOARD numbering schema
    GPIO.setmode(GPIO.BOARD)

    # set up GPIO output channel
    GPIO.setup(pin_num, GPIO.OUT)

    # creates instance associated with pin and sets frequency of Hz
    p = GPIO.PWM(pin_num, 50)

    # sets initial duty cycle
    # dc = length / period
    p.start(7.5)

    for i in range(servings):
            p.ChangeDutyCycle(7.5)  # turn towards 90 degree
            time.sleep(sleep_time) # sleep 1 second
            p.ChangeDutyCycle(2.5)  # turn towards 90 degree
            time.sleep(sleep_time) # sleep 1 second
            p.ChangeDutyCycle(12.5)  # turn towards 90 degree
            time.sleep(sleep_time) # sleep 1 second

    p.stop()
    GPIO.cleanup()
dispense_cereal(1,0)
