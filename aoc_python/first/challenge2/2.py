file_name = "challenge2.txt"

with open(file_name) as f:
    content = f.readlines()
content = [x.strip() for x in content]


def count_area(content):
    total = 0
    for dimensions in content:
        dimensions_array = dimensions.split('x')
        length = int(dimensions_array[0])
        width = int(dimensions_array[1])
        height = int(dimensions_array[2])

        required_area = 2 * length * width + 2 * width * height + 2 * height * length + \
                min(length * width, width * height, height * length)

        total += required_area

    return total


def count_ribbon_length(content):
    total = 0
    for dimensions in content:
        dimensions_array = dimensions.split('x')
        length = int(dimensions_array[0])
        width = int(dimensions_array[1])
        height = int(dimensions_array[2])

        longest_side = max(length, width, height)

        if longest_side == length:
            perimeter = 2 * width + 2 * height
        elif longest_side == width:
            perimeter = 2 * length + 2 * height
        else:
            perimeter = 2 * length + 2 * width

        volume = length * width * height

        total += volume + perimeter

    return total


print "Part 1: ", count_area(content)
print "Part 2: ", count_ribbon_length(content)
