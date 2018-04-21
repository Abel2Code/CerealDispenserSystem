import speech_recognition as sr

# def getVoiceInput():
#     r = sr.Recognizer()
#     with sr.Microphone() as source:
#         r.adjust_for_ambient_noise(source)  # listens for ambient sound
#         print(r.energy_threshold)
#         r.dynamic_energy_threshold = False
#         print("listening")
#         # audio = r.listen(source, timeout=5)
#         # audio = r.listen(source, phrase_time_limit=2)
#         audio = r.listen(source)
#         try:
#             return r.recognize_google(audio)
#         except sr.UnknownValueError:
#             return "Could not understand audio"
#         except sr.RequestError as e:
#             return "Could not request results"

def getVoiceInput():
    r = sr.Recognizer()

    with sr.Microphone() as source:
        print('Ready...')
        r.pause_threshold = 1
        r.adjust_for_ambient_noise(source, duration=1)
        audio = r.listen(source)

    try:
        #command = r.recognize_google(audio).lower()
       command = r.recognize_sphinx(audio)
       print('You said: ' + command + '\n')
    #loop back to continue to listen for commands if unrecognizable speech is received
    except sr.UnknownValueError:
        print('Your last command couldn\'t be heard')
        command = 'Your last command couldn\'t be heard'
        # command = getVoiceInput();

    return command
