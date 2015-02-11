var fun1 = function(name) {
	print('Hi there from Javascript, ' + name);
	return "greetings from javascript";
};

var fun2 = function (object) {
	print("JS Class Definition: " + Object.prototype.toString.call(object));
};

var MyJavaClass = Java.type("sk.erni.ban.answers.chapter5.Question5");
var result = MyJavaClass.helloWorld("John Doe");
print(result);


MyJavaClass.fun2(123);

MyJavaClass.fun2(49.99);

MyJavaClass.fun2(true);

MyJavaClass.fun2("hi there")

MyJavaClass.fun2(new Number(23));

MyJavaClass.fun2(new Date());

MyJavaClass.fun2(new RegExp());

MyJavaClass.fun2({foo: 'bar'});


var list2 = new java.util.ArrayList();
list2.add("ddd2");
list2.add("aaa2");
list2.add("bbb1");
list2.add("aaa1");
list2.add("bbb3");
list2.add("ccc");
list2.add("bbb2");
list2.add("ddd1");

list2
	.stream()
	.filter(function(el) {
		return el.startsWith("aaa");
	})
	.sorted()
	.forEach(function(el) {
		print(el);
	});