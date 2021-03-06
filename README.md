<p align="center"><img src="https://raw.githubusercontent.com/Scriptlang/Scriptlang-Design/master/General/Resources/Logos/logo1/logo1_200x200.png"></p>

# Scriptlang

Scriptlang is a cross-platform solution/alternative to the current scripting languages Batch and Shell.

It is an intermediate language that compiles to either Batch or Shell and is capable of running its own scripts in a "JIT" fashion without having to necessarily compile to either language (which are platform dependent).

Also, it will be possible to translate the intermediate language into any other scripting language, for example Powershell.


# How to compile

We don't have an acessible build system set in place just yet. You'll have to use Eclipse and import this project into your IDE and compile it from there.


# How to run  

For now, we can only run scripts as tests.  

To run them, simply type on the command line:  

```bash
python test.pyc <scriptfile>
```

For example:

```bash
python test.pyc ex1.sl
```

Make sure your current working directory is `<top>/test`.


# NOTE: This is a long term project with no release date set  
