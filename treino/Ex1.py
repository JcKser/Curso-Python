n = int(input())
seq = [int(input()) for _ in range(n)]

# Começamos marcando o primeiro
count = 1
prev = seq[0]

for i in range(1, n):
    if seq[i] != prev:
        count += 1
        prev = seq[i]  # atualiza o último marcado

print(count)
