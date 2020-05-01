
train-token:
	opennlp TokenizerTrainer -model output/lt-token.bin -abbDict resources/abb.xml -alphaNumOpt true -lang lt -data resources/lt-token.train -encoding UTF-8

eval-token:
	opennlp TokenizerMEEvaluator -model src/main/resources/models/lt-token.bin -data resources/lt-token.eval -encoding UTF-8

train-sent:
	opennlp SentenceDetectorTrainer -model output/lt-sent.bin -lang lt -data resources/lt-sent.train -encoding UTF-8

eval-sent:
	opennlp SentenceDetectorEvaluator -model src/main/resources/models/lt-sent.bin -data resources/lt-sent.eval -encoding UTF-8

eval: eval-token eval-sent
