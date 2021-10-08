package com.hrithikraj.mew;

import java.util.List;

interface MewCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
}