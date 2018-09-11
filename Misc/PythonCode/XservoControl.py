import time
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setup(4, GPIO.OUT)
p = GPIO.PWM(4, 50) #GPIO Channel 4 @ 50Hz
p.start(0)
try:
    while 1:
        for dc in range(0, 101, 5):
            p.ChangeDutyCycle(dc)
            time.sleep(1)
        for dc in range(100 -1, -5):
            p.ChangeDutyCycle(dc)
            time.sleep(1)
except KeyboardInterrupt:
    pass
p.stop()
GPIO.cleanup()