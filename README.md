# Fasta tools
Reads a fasta file and performs simple analyses.

## Introduction

Key Features:
* Upon opening a file, removal of duplicate entries
* Sorting entries by ascending or descending order of length.
* Removing queried entries
* Generating a new file / overwriting with queried entries only

## Running
Compile all classes under `src`: 

```
javac src/*.java
```

Then run

```
java src/FastaTools
``` 

with the following arguments.

Remove and browse require a `p` pattern in position 2. For sorting (`sd` and `ad`), position 2 becomes `outFile`.

For example:

```
java src/FastaTools in.fasta r dummy out.fasta
```
will create/overwrite a file `out.fasta` with all entries in `in.fasta` except the ones containing the pattern `dummy` in their sequence identifier.

```
java src/FastaTools in.fasta sd out.fasta
```

will create/overwrite a file `out.fasta` with all entries in `in.fasta` sorted by descending length.

### Table of arguments

<table>
    <thead>
        <tr>
            <th>Position</th>
            <th>Argument</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan=1>0</td>
            <td rowspan=1>file (File path)</td>
            <td>Path of the FASTA to be analyzed</td>
        </tr>
        <tr>
            <td rowspan = 5>1</td>
        </tr>
        <tr>
            <td rowspan=1>r</td>
            <td>Remove queried sequences, return the rest</td>
        </tr>
        <tr>
            <td>b</td>
            <td>Browse and return queried sequences</td>
        </tr>
                <tr>
            <td>sd</td>
            <td>Sort entries in descending sequence length order</td>
        </tr>
                </tr>
                <tr>
            <td>ad</td>
            <td>Sort entries in ascending sequence length order</td>
        </tr>
        </tr>
  <tr>
    <td>2</td>
    <td>p</td>
    <td>Pattern to query</td>
  </tr>
    <tr>
    <td>3</td>
    <td>outFile (File path)</td>
    <td>File to create/overwrite with result</td>
  </tr>
    </tbody>
</table>

(Work in progress)



