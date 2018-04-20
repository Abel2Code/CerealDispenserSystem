from __future__ import division
import time
import sys

import Adafruit_PCA9685

pwm = Adafruit_PCA9685.PCA9685()

servo_min = 150  # Min pulse length out of 4096
servo_max = 600  # Max pulse length out of 4096

try:
    first_arg = int(float(sys.argv[1]))
    second_arg = int(float(sys.argv[2]))
except:
    first_arg = 15 # Do not use channel 15!
    second_arg = 15
    
pwm.set_pwm_freq(60)

def spinChannel(channel=first_arg, num_spins=second_arg):
    for i in range(num_spins):
        pwm.set_pwm(channel, 0, servo_min)
        time.sleep(1)
        pwm.set_pwm(channel, 0, servo_max)
        time.sleep(1)
        
if __name__ == "__main__":    
    spinChannel()
