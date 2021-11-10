package com.hrithikraj.mew;

import java.util.List;
import java.util.Map;

class MewClass implements MewCallable {
    final String name;
    private final Map<String, MewFunction> methods;
    final MewClass superclass;

    MewClass(String name, MewClass superclass, Map<String, MewFunction> methods) {
        this.superclass = superclass;
        this.name = name;
        this.methods = methods;
    }

    MewFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        if (superclass != null) {
            return superclass.findMethod(name);
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
