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

print("\n");

print("A ^ 2: " + str(li["A"]**2))
print("B ^ 2: " + str(li["B"]**2))
print("C ^ 2: " + str(li["C"]**2))
print("D ^ 2: " + str(li["D"]**2))
print("E ^ 2: " + str(li["E"]**2))
print("F ^ 2: " + str(li["F"]**2))
print("G ^ 2: " + str(li["G"]**2))
print("H ^ 2: " + str(li["H"]**2))
print("A ^ 5: " + str(li["A"]**5))
print("B ^ 5: " + str(li["B"]**5))
print("C ^ 5: " + str(li["C"]**5))
print("D ^ 5: " + str(li["D"]**5))
print("E ^ 5: " + str(li["E"]**5))
print("F ^ 5: " + str(li["F"]**5))
print("G ^ 5: " + str(li["G"]**5))
print("H ^ 5: " + str(li["H"]**5))
print("A ^ 10: " + str(li["A"]**10))
print("B ^ 10: " + str(li["B"]**10))
print("C ^ 10: " + str(li["C"]**10))
print("D ^ 10: " + str(li["D"]**10))
print("E ^ 10: " + str(li["E"]**10))
print("F ^ 10: " + str(li["F"]**10))
print("G ^ 10: " + str(li["G"]**10))
print("H ^ 10: " + str(li["H"]**10))
print("A ^ 25: " + str(li["A"]**25))
print("B ^ 25: " + str(li["B"]**25))
print("C ^ 25: " + str(li["C"]**25))
print("D ^ 25: " + str(li["D"]**25))
print("E ^ 25: " + str(li["E"]**25))
print("F ^ 25: " + str(li["F"]**25))
print("G ^ 25: " + str(li["G"]**25))
print("H ^ 25: " + str(li["H"]**25))
