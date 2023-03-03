p = eval(input())
n = eval(input())
r, c = input().split(',')
r = eval(r)
c = eval(c)
mode = input()
phares = []
for i in range(p):
    phares.append(input())
#读密码表
table = ""
flag = True
for i in range(n):
    str1 = input()
    for word in str1:
        if word == ">" and ~flag:
            flag = True
            continue
        if word == "<" and flag:
            flag = False
            continue
        if flag:
            table = table + word

if r*c < len(table):
    table = table[:r*c]

for phare in phares:
    result = []
    for i in range(len(phare)):
        if mode == "S":
            idx = table.find(phare[i])
        else:
            idx = table.rfind(phare[i])
        
        if idx >= 0:
            result.append(idx//c+1)
            result.append(idx % c+1)
        else:
            result=[0]
            break
        
    for i in range(len(result)):
        if(i == len(result)-1):
            print(result[i], end='\n')
            break
        print(result[i], end=',')
