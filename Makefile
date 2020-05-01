
train-token:
	opennlp TokenizerTrainer -model output/lt-token.bin -abbDict resources/abb.xml -alphaNumOpt true -lang lt -data resources/lt-token.train -encoding UTF-8

eval-token:
	opennlp TokenizerMEEvaluator -model src/main/resources/models/lt-token.bin -data resources/lt-token.eval -encoding UTF-8
