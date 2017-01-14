filename = "challenge1.txt"

with open(filename) as f:
    content = f.readline()


def count_floor(file_content):
    floor = 0
    for char in file_content:
        if char == '(':
            floor += 1
        elif char == ')':
            floor -= 1
    return floor


def count_when_basement(file_content):
    floor = 0
    position = 0
    for char in file_content:
        if char == '(':
            floor += 1
        elif char == ')':
            floor -= 1
        position += 1

        if floor == -1:
            return position

print "Part 1: ", count_floor(content)
print "Part 2: ", count_when_basement(content)
