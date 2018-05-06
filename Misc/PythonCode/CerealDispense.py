# Servo ON - OFF // For opening and closing container doors measured by time
#
import time
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setup(4, GPIO.OUT)

p = GPIO.PWM(4, 50) #GPIO Channel 4 @ 50Hz
p.start(2.5)

try:
    while True:
            p.ChangeDutyCycle(2.5)  # 0
            time.sleep(0.5)
            p.ChangeDutyCycle(7.5)  # 90
            time.sleep(0.5)
            p.ChangeDutyCycle(12.5) # 180
            time.sleep(0.5)
            p.ChangeDutyCycle(7.5)  # 90
            time.sleep(0.5)
            
except KeyboardInterrupt:
    p.stop()
    GPIO.cleanup()
