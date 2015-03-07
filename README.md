# 3F

Three main components - (1) NLP (2) Centre (3) Datastore

(1) NLP - Responsible to break sentence into nouns, verb etc.

(2) Centre - Reponsible to take teh input from NLP and invoke one or more methods from the datastore

(3) Datastore - Holds two entities - (a) AnnotationRepository (columns - id, annotation, reference to ActionRepository)
                                     (b) ActionRepository (columns - id, methodName, Action)
