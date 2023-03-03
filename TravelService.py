T = eval(input())
for i in range(T):
    s, c, r0 = input().split(' ')
    s = int(s)
    c = int(c)
    r0 = int(r0)
    station = []
    station.append([0,0])
    for j in range(1, s+1):
        f, r = input().split(' ')
        f = int(f)
        r = int(r)
        station.append([f, r])
        station[j][0] = station[j][0] + station[j-1][0]

    dp = [1e12 for x in range(s+1)]
    dp[0] = c * r0
    result = 1e12

    for k in range(1,s+1):
        for l in range(k-1,-1, -1):
            if(c < station[k][0] - station[l][0]):
                break
            cost = (station[k][0] - station[l][0])*station[k][1] + 500 + dp[l]
            dp[k] = min(dp[k], cost)

    for k in range(s,-1,-1):
        if(c < station[s][0] - station[k][0]):
            break
        result = min(result, dp[k])
    print(result)
