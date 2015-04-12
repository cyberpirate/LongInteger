li = {}
li["A"] = 2222
li["B"] = 99999999
li["C"] = -246813575732
li["D"] = 180270361023456789
li["E"] = 1423550000000010056810000054593452907711568359
li["F"] = -350003274594847454317890
li["G"] = 29302390234702973402973420937420973420937420937234872349872934872893472893749287423847
li["H"] = -98534342983742987342987339234098230498203894209928374662342342342356723423423

for x in li:
    for y in li:
        print(str(x) + " + " + str(y) + ": " + str(li[x]+li[y]))
        print(str(x) + " - " + str(y) + ": " + str(li[x]-li[y]))
        print(str(x) + " * " + str(y) + ": " + str(li[x]*li[y]))

li["I"] = li["A"] + li["D"]
li["J"] = li["B"] + li["C"]
li["K"] = li["C"] + li["D"]
li["L"] = li["I"] + li["I"]
li["M"] = li["A"] + li["I"]
li["N"] = li["B"] + li["K"]
li["O"] = li["A"] - li["D"]
li["P"] = li["C"] - li["D"]
li["Q"] = li["D"] - li["C"]
li["R"] = li["L"] - li["L"]
li["S"] = li["P"] - li["O"]
li["T"] = li["N"] - li["Q"]
li["U"] = li["A"] * li["D"]
li["V"] = li["B"] * li["C"]
li["W"] = li["D"] * li["D"]
li["X"] = li["O"] * li["I"]
li["Y"] = li["J"] * li["P"]
li["Z"] = li["M"] * li["N"]

print("\n");

print("I:" + str(li["I"]))
print("J:" + str(li["J"]))
print("K:" + str(li["K"]))
print("L:" + str(li["L"]))
print("M:" + str(li["M"]))
print("N:" + str(li["N"]))
print("O:" + str(li["O"]))
print("P:" + str(li["P"]))
print("Q:" + str(li["Q"]))
print("R:" + str(li["R"]))
print("S:" + str(li["S"]))
print("T:" + str(li["T"]))
print("U:" + str(li["U"]))
print("V:" + str(li["V"]))
print("W:" + str(li["W"]))
print("X:" + str(li["X"]))
print("Y:" + str(li["Y"]))
print("Z:" + str(li["Z"]))
