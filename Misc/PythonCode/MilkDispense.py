# ON - OFF // For Milk Dispensing Module measured by time
#blink.py
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(4, GPIO.OUT)
GPIO.output(4, True)
time.sleep(2)
GPIO.output(4,False)