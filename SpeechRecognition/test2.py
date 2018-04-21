#!/usr/bin/env python3

from SpeechRecognitionModule import getVoiceInput
from ResponseModule import say

# Comparign algoritihm can compare length and (first or last letter)

say('Say Something')
say(getVoiceInput())
