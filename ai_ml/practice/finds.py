data = [
    ['Sunny', 'Warm', 'Normal', 'Strong', 'Warm', 'Same', 'Yes'],
    ['Sunny', 'Warm', 'High', 'Strong', 'Warm', 'Same', 'Yes'],
    ['Rainy', 'Cold', 'High', 'Strong', 'Warm', 'Change', 'No'],
    ['Sunny', 'Warm', 'High', 'Strong', 'Cool', 'Change', 'Yes']
]


def find_s(examples):
    hypothesis = ['ϕ','ϕ','ϕ','ϕ','ϕ','ϕ']

    for example in examples:
        if(example[-1]=='Yes'):
            for i in range(len(hypothesis)):
                if(hypothesis[i]=='ϕ'):
                    hypothesis[i] = example[i]
                elif(hypothesis[i]!=example[i]):
                    hypothesis[i]='?'
    
    return hypothesis



hypothesis = find_s(data)
print("Final Hypothesis: ", hypothesis)

