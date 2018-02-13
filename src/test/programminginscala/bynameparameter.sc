var assertionEnabled = false

def myAssert(predicate: () => Boolean) = if(assertionEnabled && !predicate()) throw new AssertionError
def myAssert2(predicate:  => Boolean) = if(assertionEnabled && !predicate) throw new AssertionError


//myAssert(5 < 3)
myAssert2(5 < 3)
myAssert2(throw new Exception)
