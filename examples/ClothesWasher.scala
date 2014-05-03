class ClothesWasher(modelName:String, capacity:Double) {
	def this(modelName:String) {
		this(modelName, 6.0)
	}
	def this(capacity:Double) {
		this("some model", capacity)
	}
}

new ClothesWasher("other model")
new ClothesWasher(9.0)
new ClothesWasher("small", 3.0)
