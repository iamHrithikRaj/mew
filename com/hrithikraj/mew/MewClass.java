package com.hrithikraj.mew;

import java.util.List;
import java.util.Map;

class MewClass implements MewCallable {
    final String name;
    private final Map<String, MewFunction> methods;

    MewClass(String name, Map<String, MewFunction> methods) {
        this.name = name;
        this.methods = methods;
    }

    MewFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        MewInstance instance = new MewInstance(this);
        MewFunction initializer = findMethod("init");
        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }
        return instance;
    }

    @Override
    public int arity() {
        MewFunction initializer = findMethod("init");
        if (initializer == null)
            return 0;
        return initializer.arity();
    }
}
