
train-token:
	opennlp TokenizerTrainer -model output/lt-token.bin -abbDict resources/abb.xml -alphaNumOpt true -lang lt -data resources/lt-token.train -encoding UTF-8

eval-token:
	opennlp TokenizerMEEvaluator -model src/main/resources/models/lt-token.bin -data resources/lt-token.eval -encoding UTF-8

train-sent:
	opennlp SentenceDetectorTrainer -model output/lt-sent.bin -lang lt -data resources/lt-sent.train -encoding UTF-8

eval-sent:
	opennlp SentenceDetectorEvaluator -model src/main/resources/models/lt-sent.bin -data resources/lt-sent.eval -encoding UTF-8

train-pos:
	opennlp POSTaggerTrainer -model output/lt-pos.bin -lang lt -data resources/lt-pos.train -encoding UTF-8

eval-pos:
	opennlp POSTaggerEvaluator -model src/main/resources/models/lt-pos.bin -data resources/lt-pos.eval -encoding UTF-8

train-lemmatizer:
	opennlp LemmatizerTrainerME -model output/lt-lemmatizer.bin -lang lt -data resources/lt-lemmatizer.train -encoding UTF-8

eval-lemmatizer:
	opennlp LemmatizerEvaluator -model src/main/resources/models/lt-lemmatizer.bin -data resources/lt-lemmatizer.eval -encoding UTF-8

train-ner-person:
	opennlp TokenNameFinderTrainer -model output/lt-ner-person.bin -lang lt -data resources/lt-ner-person.train -encoding UTF-8

eval-ner-person:
	opennlp TokenNameFinderEvaluator -model src/main/resources/models/lt-ner-person.bin -data resources/lt-ner-person.eval -encoding UTF-8

train-ner-location:
	opennlp TokenNameFinderTrainer -model output/lt-ner-location.bin -lang lt -data resources/lt-ner-location.train -encoding UTF-8

eval-ner-location:
	opennlp TokenNameFinderEvaluator -model src/main/resources/models/lt-ner-location.bin -data resources/lt-ner-location.eval -encoding UTF-8

train-ner-organization:
	opennlp TokenNameFinderTrainer -model output/lt-ner-organization.bin -lang lt -data resources/lt-ner-organization.train -encoding UTF-8

eval-ner-organization:
	opennlp TokenNameFinderEvaluator -model src/main/resources/models/lt-ner-organization.bin -data resources/lt-ner-organization.eval -encoding UTF-8

train-ner-time:
	opennlp TokenNameFinderTrainer -model output/lt-ner-time.bin -lang lt -data resources/lt-ner-time.train -encoding UTF-8

eval-ner-time:
	opennlp TokenNameFinderEvaluator -model src/main/resources/models/lt-ner-time.bin -data resources/lt-ner-time.eval -encoding UTF-8

train-ner:
	make train-ner-person
	make train-ner-location
	make train-ner-organization
	make train-ner-time

eval-ner:
	make eval-ner-person
	make eval-ner-location
	make eval-ner-organization
	make eval-ner-time

eval: eval-token eval-sent eval-pos eval-lemmatizer eval-ner
