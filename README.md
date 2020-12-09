# Mite-HTTP-Server
A very simple Java HTTP server. It is meant to be a starting skeleton without
extra dependencies. It requires Java 5 or better, but is so tiny it could easily
be ported to an earlier JRE or a different JVM language.

See [Start](src/main/java/mite/Start.java) for starting a server that echos responses.

To write a server that does something else, use a different implementation of [HTTPRequestHandler](src/main/java/mite/HTTPRequestHandler.java).
