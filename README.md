# vector-primitives-cljs

An experimental implementation of something approximating `vector-of` in clojurescript.

[![Clojars Project](https://img.shields.io/clojars/v/vector-primitives-cljs.svg)](https://clojars.org/vector-primitives-cljs)

## Overview

This library is primarily a way for me to split out the implementation of a
`vector-of` like datastructure in clojurescript and to get some exposure to
working in the language internals.

The existence of any official implementation is a signal to stop using this library.

It is very likely this will be derivative.

## Development

To get an interactive development environment run:

    lein fig:dev

This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

	lein clean

To create a production build run:

	lein clean
	lein fig:min


## License

Copyright © 2018 Folcon

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
