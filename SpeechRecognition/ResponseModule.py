import pyttsx

# Initialize Text-to-Speech
engine = pyttsx.init()

def say(text):
    engine.say(text)
    engine.runAndWait()