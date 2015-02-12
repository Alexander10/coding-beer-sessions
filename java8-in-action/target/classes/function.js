function runJavaMethod(predicate, obj) {
	return !!(eval(predicate));
};

/**
 * function creates person java object
 * @param name
 * @param age
 * @returns {*}
 */
function createPerson(name, age) {

	return null;

}

function Product(name, price, stock) {
	this.name = name;
	this.price = price;
	this.stock = stock;

	this.getName = function () {
		return this.name;
	}

	this.getPrice = function() {
		return this.price;
	}

	this.getStock = function() {
		return this.stock;
	}

}

function createProduct() {
	var product = new Product("Beer", "2", "BA");
	var Question = Java.type('sk.erni.ban.answers.chapter5.Question5');
	Question.fillData(product);
}

