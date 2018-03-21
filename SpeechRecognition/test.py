#!/usr/bin/env python3

import speech_recognition as sr
import pyttsx

#pip install git+git://github.com/jpercent/pyttsx.gits
# Initialize Engine
engine = pyttsx.init()

# get audio from the microphone
def turnOn():
	r = sr.Recognizer()
	with sr.Microphone() as source:
		input = ""
		while "system on" not in input.lower():
			r.adjust_for_ambient_noise(source) # listens for ambient sound
			print("Speak:")
			audio = r.listen(source)
			try:
				input = r.recognize_google(audio)
				print("You said " + r.recognize_google(audio))
			except sr.UnknownValueError:
				print("Could not understand audio")
			except sr.RequestError as e:
				print("Could not request results; {0}".format(e))

	engine.say('Cereal Dispenser System Online')
	engine.runAndWait()

engine.say('Cereal Dispenser System Online')
engine.runAndWait()

engine.say('What type of Cereal would you like?')
engine.runAndWait()
cerealType = ""
r = sr.Recognizer()
with sr.Microphone() as source:
	r.adjust_for_ambient_noise(source) # listens for ambient sound
	print("Speak:")
	audio = r.listen(source)
	try:
		cerealType = r.recognize_google(audio)
		print("You said " + cerealType)
	except sr.UnknownValueError:
		print("Could not understand audio")
	except sr.RequestError as e:
		print("Could not request results; {0}".format(e))

engine.say('Would you like Regular, Large, or Extra Large Servings')
engine.runAndWait()
size = ""
# while not ("extra large" in size.lower() or "large" in size.lower() or "regular" in size.lower()):
r = sr.Recognizer()
with sr.Microphone() as source:
	r.adjust_for_ambient_noise(source) # listens for ambient sound
	print("Speak:")
	audio = r.listen(source)
	try:
		size = r.recognize_google(audio)
		print("You said " + cerealType)
	except sr.UnknownValueError:
		print("Could not understand audio")
		engine.say('Sorry I did not catch that.')
		engine.runAndWait()
	except sr.RequestError as e:
		print("Could not request results; {0}".format(e))

engine.say('Would you like Regular or 2 percent milk?')
engine.runAndWait()
milkType = ""
r = sr.Recognizer()
with sr.Microphone() as source:
	r.adjust_for_ambient_noise(source) # listens for ambient sound
	print("Speak:")
	audio = r.listen(source)
	try:
		milkType = r.recognize_google(audio)
		print("You said " + milkType)
	except sr.UnknownValueError:
		print("Could not understand audio")
		engine.say('Sorry I did not catch that.')
		engine.runAndWait()
	except sr.RequestError as e:
		print("Could not request results; {0}".format(e))

engine.say('You Ordered ' + cerealType + ' of ' + size + ' size with ' + milkType + ' milk. Correct?')
print('You Ordered ' + cerealType + ' of ' + size + ' size with ' + milkType + ' milk. Correct?')
